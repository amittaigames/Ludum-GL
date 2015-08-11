# Ludum GL

## What is Ludum GL?

Ludum GL is a game engine made with OpenGL for Ludum Dare. It was made for Ludum Dare 33.


## Is there documentation?

There are comments within the code, explaining the use of each method. Unfortunately that's all there is. I'm working on functionality more than documentation at the moment, because as of now, Ludum Dare is fast approaching!


## Your OpenGL code is super old

Thank you, I know. It should be able to run on your system without a problem :)


## Whenever I run a game using Ludum GL, it takes forever to start

That's because of Slick Util's font loading. In order to display a font with Open GL, that's pretty much the way it's gonna have to happen. It takes a few seconds to load a font that way, but it allows the developers to change fonts in their update and render code.


## Where can I get the latest library?

Current Version: 0011 [Download](https://app.box.com/s/8det3ghxh09royqs2vn2tc33a07uuu1u)

If the library is older than the current code, feel free to build from source.