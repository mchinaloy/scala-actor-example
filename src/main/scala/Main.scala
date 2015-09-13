import application._

object Main extends App {

  val carPaintingFactoryActor = new CarPaintingFactoryActor
  val carFactoryActor = new CarFactoryActor(carPaintingFactoryActor)
  val coachworkFactoryActor = new CoachworkFactoryActor(carFactoryActor)
  val wheelFactoryActor = new WheelFactoryActor(carFactoryActor)
  val engineFactoryActor = new EngineFactoryActor(carFactoryActor)

  carFactoryActor.start()
  wheelFactoryActor.start()
  engineFactoryActor.start()
  coachworkFactoryActor.start()

}
