package com.thepwo.ggwave.api;

public interface GGWaveAPI {

    /**
     * Check if there is any GG wave currency running
     *
     * @return ~ whether any GG is running
     */
    boolean isGGWaveRunning();

    /**
     * Start a GG wave, failing silently if a GG wave is already running
     *
     * @param duration ~ Number of seconds the GG wave should last
     */
    void startGGWave(long duration);

    /**
     * Stops any current GG wave, failing silently if there is no current GG wave
     */
    void stopGGWave();
}
