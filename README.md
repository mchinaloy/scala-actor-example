# ScalaActorExample
A short example demonstrating how to use the Scala Actor model for concurrency.

It simulates a Car Factory whereby we have the following:

1. CoachworkFactoryActor/EngineFactoryActor/WheelFactoryActor producing components for our Car
2. We need one Coachwork, one Engine and four Wheels at then we can create a Car
3. Every Car then gets painted by the CarPaintFactoryActor

On my somewhat low powered machine I'm seeing 6250 Cars being produced every second.

This project is lacking tests at the moment.
