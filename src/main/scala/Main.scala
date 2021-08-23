import objects.{Consumer, Producer}

object Main extends App{
  Producer.exec()
  Consumer.exec()
}
