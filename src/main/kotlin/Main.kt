fun main(args: Array<String>) {
    val port: Int = if (args.isNotEmpty()) {
        Integer.parseInt(args[0]);
    } else {
        8080;
    }
    DiscardServer(port).run();
}