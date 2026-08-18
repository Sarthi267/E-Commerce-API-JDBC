package com.example.ecommerceapi;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StockUpdateService {
    private final Map<Long, List<SseEmitter>> emittersByListing = new ConcurrentHashMap<>();

    public SseEmitter createEmitter(Long listingId) {
      SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

      emittersByListing.computeIfAbsent(listingId, k -> new java.util.concurrent.CopyOnWriteArrayList<>()).add(emitter);

        emitter.onCompletion(() -> emittersByListing.remove(emitter));
        emitter.onTimeout(() -> emittersByListing.remove(emitter));
        emitter.onError(e -> emittersByListing.remove(emitter));

        return emitter;
    }
    public void sendStockUpdate(Long listingId, int newStock){
      List<SseEmitter> emitters = emittersByListing.getOrDefault(listingId, List.of());
      for(SseEmitter emitter : emitters){
          try {
              emitter.send(SseEmitter.event()
                      .name("stock-update")
                      .data("Listing " + listingId + " new stock: " + newStock));
          }
              catch(IOException e){
                  emitter.complete();
                  emitters.remove(emitter);
              }

      }
    }
}
