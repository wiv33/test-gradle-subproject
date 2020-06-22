Chap02
=
# testing Gradle multi project command

[Project layout: gradle docs](https://docs.gradle.org/current/userguide/multi_project_builds.html)
-
├── build.gradle.kts  
├── consumer  
│   └── build.gradle.kts  
├── producer  
│   └── build.gradle.kts  
└── settings.gradle.kts  


### include("producer", "consumer")

    gradlew action
    
    Running...
    > consumer > producer
    extra["producerMessage"] is null
    
---

### include("aProducer", "consumer")
    
    Running
    > aProducer > consumer
    extra["producerMessage"] is Watch the order of execution.
