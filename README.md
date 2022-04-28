[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]


<!-- PROJECT TITLE -->
<!--suppress HtmlDeprecatedAttribute, HtmlUnknownAnchorTarget -->

<div align="center">
<h3 align="center">GG Wave</h3>
  <p align="center">
    Lightweight plugin to say GGs to your donors!
    <br/>
    <a href="https://github.com/TheTrustyPwo/GGWave/issues">Report Bug</a>
    ·
    <a href="https://github.com/TheTrustyPwo/GGWave/issues">Request Feature</a>
  </p>
</div>


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#commands">Commands</a></li>
    <li><a href="#developer-api">Developer API</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project

Extremely lightweight yet essential plugin to encourage donating.

Here's why you should use this plugin:
* Lightweight & Optimized
* Easy setup; Drag & Drop
* All messages are configurable, even with documentation!
* Developer API in case you want to implement this in your plugins!

<p align="right">(<a href="#top">back to top</a>)</p>


## Commands
This is a list of commands available in the plugin. Note that all commands require the `ggwave.admin` permission!

| Command | Description |
| ------- | ----------- |
| `/ggwave` | Display's the help menu |
| `/ggwave start <duration>` | Start a GG wave with the specified duration in seconds |
| `/ggwave stop` | Stop the current GG wave |

<p align="right">(<a href="#top">back to top</a>)</p>


## Developer API
This section is for developers who want to make use of this plugin's API.

### API
```java
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
```

To get the API implementation:
```java
GGWaveAPI api =  ((GGWave) Bukkit.getPluginManager().getPlugin("GGWave")).getPlugin().getApi();
```

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

TheTrustyPwo - Pwo#0001 - thetrustypwo@gmail.com

Project Link: [https://github.com/TheTrustyPwo/GGWave](https://github.com/TheTrustyPwo/GGWave)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/TheTrustyPwo/GGWave.svg?style=for-the-badge
[contributors-url]: https://github.com/TheTrustyPwo/GGWave/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/TheTrustyPwo/GGWave.svg?style=for-the-badge
[forks-url]: https://github.com/TheTrustyPwo/GGWave/network/members
[stars-shield]: https://img.shields.io/github/stars/TheTrustyPwo/GGWave.svg?style=for-the-badge
[stars-url]: https://github.com/TheTrustyPwo/GGWave/stargazers
[issues-shield]: https://img.shields.io/github/issues/TheTrustyPwo/GGWave.svg?style=for-the-badge
[issues-url]: https://github.com/TheTrustyPwo/GGWave/issues
[license-shield]: https://img.shields.io/github/license/TheTrustyPwo/GGWave.svg?style=for-the-badge
[license-url]: https://github.com/TheTrustyPwo/GGWave/blob/master/LICENSE.txt