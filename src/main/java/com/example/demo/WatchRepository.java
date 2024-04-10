package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WatchRepository {

    private final Map<String, Watch> watchMap = Map.of(
            "001", new Watch("001", "Rolex", 100),
            "002", new Watch("002", "Michael Kors", 80),
            "003", new Watch("003", "Swatch", 50),
            "004", new Watch("004", "Casio", 30));

    // This would usually be a database call, but using map for simplicity
    public List<Watch> getWatchesFromIds(List<String> ids) {
        return ids.stream()
                .map(watchMap::get)
                .toList();
    }
}
