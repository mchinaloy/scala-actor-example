package application.paint

import java.util.Calendar

import scala.actors.Actor

class CarPaintingFactoryActor extends Actor {

  var carsProduced: Int = 0

  override def act(): Unit = {
    while (true) {
      receive {
        case msg =>
          carsProduced = carsProduced + 1
          if(carsProduced == 100000){
            println("100K Produced in: " + Calendar.getInstance().getTime)
          } else if(carsProduced == 300000){
            println("300K Produced in: " + Calendar.getInstance().getTime)
          } else if(carsProduced == 500000){
            println("500K Produced in: " + Calendar.getInstance().getTime)
          } else if(carsProduced == 1000000){
            println("1MM Produced in: " + Calendar.getInstance().getTime)
          }
      }
    }
  }

}
