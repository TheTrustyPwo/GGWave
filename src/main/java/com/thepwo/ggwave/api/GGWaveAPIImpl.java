package com.thepwo.ggwave.api;

import com.thepwo.ggwave.GGWave;

public class GGWaveAPIImpl implements GGWaveAPI {
    private final GGWave plugin = GGWave.getPlugin();

    @Override
    public boolean isGGWaveRunning() {
        return plugin.isGgWaveRunning();
    }

    @Override
    public void startGGWave(long duration) {
        if (!isGGWaveRunning()) {
            this.plugin.startGGWave(duration);
        }
    }

    @Override
    public void stopGGWave() {
        if (isGGWaveRunning()) {
            this.plugin.setGgWaveRunning(false);
        }
    }
}
