package org.example

fun main(args: Array<String>) {
    val t=Thread {
        println("Before sleep (interrupted)")

        try {
            Thread.sleep(60000);

            println("After sleep (interrupted, no exception)")
        }catch(e: InterruptedException){
            println("Thread was interrupted in sleep (exception)")

            while(true){
                if (Thread.interrupted()){
                    println("Interrupted in active state (flag isInterrupted)")
                    break;

                }
            }

        }

        println("Thread stops")
    }

    t.start()

    while(!t.isAlive){}

    println("After thread run")

    t.interrupt()

    Thread.sleep(10000)

    t.interrupt()

}

