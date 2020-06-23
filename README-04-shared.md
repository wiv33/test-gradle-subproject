Chap04: api - service - with shared
=

command
-
 
    gradle build
    

project layout
-
.
├── api  
│   └── src  
│       ├── main  
│       │   └── java  
│       │       └── org  
│       │           └── gradle  
│       │               └── sample  
│       │                   ├── api  
│       │                   │   └── Person.java  
│       │                   └── apiImpl  
│       │                       └── PersonImpl.java  
│       └── test  
│           └── java  
│               └── org  
│                   └── gradle  
│                       └── PersonTest.java  
├── build.gradle.kts  
├── services  
│   └── personService  
│       └── src  
│           ├── main  
│           │   └── java  
│           │       └── org  
│           │           └── gradle  
│           │               └── sample  
│           │                   └── services  
│           │                       └── PersonService.java  
│           └── test  
│               └── java  
│                   └── org  
│                       └── gradle  
│                           └── sample  
│                               └── services  
│                                   └── PersonServiceTest.java  
├── settings.gradle.kts  
└── shared  
    └── src  
        └── main  
            └── java  
                └── org  
                    └── gradle  
                        └── sample  
                            └── shared  
                                └── Helper.java  