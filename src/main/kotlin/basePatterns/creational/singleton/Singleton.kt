package basePatterns.creational.singleton

fun main(){
    println(ProgramLogger.getProgramLogger().toString())
    println(ProgramLogger.getProgramLogger().toString())

    val logger = ProgramLogger.getProgramLogger()
    logger.addLogInfo("First log")
    logger.addLogInfo("Second log")
    logger.showLogFile()
}

class ProgramLogger private constructor(){
    companion object{
        private var programLogger: ProgramLogger? = null
        private var logFile: String = "This is a log file\n"

        @Synchronized
        fun getProgramLogger() : ProgramLogger{
            if(programLogger == null){
                programLogger = ProgramLogger()
            }
            return programLogger as ProgramLogger
        }
    }

    fun addLogInfo(logInfo: String){
        logFile += "$logInfo\n"
    }

    fun showLogFile(){
        println(logFile)
    }
}