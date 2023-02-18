# FrameWorks and Language Used
* SpringBoot
* Java

# Data Flow
* Controller - Rest Controller

Used with @GetMapping, @RequestMapping, @PutMapping, @RequestBody, @RequestParam, @Nullable, @DeleteMapping and @AutoWired and linked with the business logic in the Service Class

* Services

addUser 
getUser/{userid}
getAllUser
updateUserInfo
deleteUser

* Repository

  Jpa Repository is used which extends CRUD Respository

# Data Structure Used

H2 Database

# Project Summary 
* This a simple API for User Information Management 
* You can manage User details with this
* All the User details are Updatable 
* If required you can also delete specific User details
* All the details are added in the H2 for easier data viewing via table of User
