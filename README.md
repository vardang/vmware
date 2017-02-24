# vmware

Task1. NamedPoint
Used technologies: C++

Task2. Production-Consumption
Used technologies: Maven, Java, SLF4J

FAQ:
Q. How to run the application?
A. Firstly you need to setup Maven on your computer. Then you should execute one of following commands:
    1. mvn package - this will generate dist directory with jar file, then jus execute java -jar dist/producer-consumer-1.0.jar
    2. mvn exec:java -Dexec.mainClass="com.vmware.interview.task2.main.Main"
    3. use IDE like IntelliJ, Eclipse, NetBeans etc.
Q. How to change use external log4j.properties configuration file
A. Execute following command:
    java -Dlog4j.configuration={PATH_TO_CONFIG_FILE} -jar producer-consumer-1.0.jar. For example in Linux it should looks like as
    java -Dlog4j.configuration=file:/home/log4j.properties -jar producer-consumer-1.0.jar
Q. How to stop running the application?
A. Just hit Enter.
