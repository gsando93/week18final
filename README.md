# week18final

**Description**
  This is a restful API. It allows you to perform CRUD operations on a database called "continuing_seed". The database contains four tables: a seed table that contains prompts for stories, a role table that contains information about the characters in the stories, a genre table 
that contains the genre of the prompt, and a join table to ensure that the relationship between seed and genre is properly established and maintained. Seed has a one-to-many relationship with Role. Seed also has a many-to-many relationship with genre.
  All entities have at least one CRUD operation that you are able to perform on them. Seed has all four CRUD operations. Roles can be created. Genres can be deleted.

**Need to know** 
  1. You will need to create a schema called "continuing_seed" through MySQL Workbench in order to run this program. You should also create a user with the same name and give it all privileges except for "grant option". You should connect it to DBeaver or something similar.
  2. Once the program is pulled from GitHub, you can use the "ARCExamples" pdf located on the main branch to get explicit examples on POST, PUT, GET, and DELETE ARC requests, including urls and comments for what they do.
  3. There is important information on the current code functionality inside of that PDF, "ARCExamples," on request phrasing that won't return an error. Namely, there is an issue with trying to create or update a seed with role
      information inside of the payload that needs to be reviewed.
