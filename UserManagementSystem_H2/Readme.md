# FrameWorks and Language Used
* SpringBoot
* Java

# Data Flow
* Controller - Rest Controller

Used with @GetMapping, @RequestMapping, @PutMapping, @RequestBody, @RequestParam, @Nullable, @DeleteMapping and @AutoWired and linked with the business logic in the Service Class

* Services

addUser, 
getUser/{userid}, 
getAllUser, 
updateUserInfo, 
deleteUser

* Repository

  Jpa Repository is used which extends CRUD Respository
  
* DataBase Design

 ###### We have a table of Users with name "tbl_user" 
 ###### It has all the attributes of user as table columns
 ###### Table attribute are 
  1. user_id
  2. user_name
  3. DOB (dd-MM-yyyy)
  4. email
  5. phone_number
  6. created_date 
  7. created_time

  ###### We have user_id as our Primary_Key in our database
 

# Data Structure Used

H2 Database

# Project Summary 
* This a simple API for User Information Management 
* You can manage User details with this
* All the User details are Updatable 
* If required you can also delete specific User details
* All the details are added in the H2 for easier data viewing via table of User
* This project contails a Util package witch is used for validation of input attributes
* We are giving a streamlined Response entity message if an attribute is not valid
* This saves the client to find what exactly has gone wrong
