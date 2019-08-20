# java-io-nio-examples
This repository consists of Java IO, NIO examples and reading huge file, finding the top 10 people from large file reading approx 1.5GB

This java class is used generate large file in minute, please terminate it if necessary. As this code can write file approximately close to size of 1 GB to 1.5 GB in a 1 minute

```
ThreadWritingToFile.java
```

The above code is currently configured to terminate in 20 seconds, please update it if necessary. If the file marks.csv is already present, the code will start adding data to existing file.
 
```java
if (executor.awaitTermination(20, TimeUnit.SECONDS)) {
	System.out.println("Closing ExecutorService thread pool gracefully");
} else {
	System.out.println("Forcing ExecutorService shutdown");
	executor.shutdownNow();
}
```
