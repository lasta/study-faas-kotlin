package binaries

data class EntryPoint(
    val packageName: String,
    val functionName: String = "main",
    val args: Array<String> = arrayOf("")
) {
    val entryPoint: String
        get() = "$packageName.$functionName"

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (javaClass != other?.javaClass) {
            return false
        }

        other as EntryPoint

        if (packageName != other.packageName) {
            return false
        }
        if (!args.contentEquals(other.args)) {
            return false
        }

        return true
    }

    override fun hashCode(): Int = packageName.hashCode() * 31 + args.contentHashCode()
}

fun supplyEntryPoints(): List<EntryPoint> = listOf(
    // TODO: generate automatically with project structure
    EntryPoint(packageName = "entrypoint.sample1"),
    EntryPoint(packageName = "entrypoint.sample2")
)
