package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WatchRepositoryTest {

    private final WatchRepository watchRepository = new WatchRepository();

    @Test
    void get_existing_watch() {
        List<Watch> watches = watchRepository.getWatchesFromIds(List.of("001"));

        assertFalse(watches.isEmpty());
        assertNotNull(watches.getFirst());
    }

    @Test
    void get_non_existing_watch() {
        List<Watch> watches = watchRepository.getWatchesFromIds(List.of("123"));

        assertTrue(watches.isEmpty());
    }
}
