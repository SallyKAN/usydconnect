README
UsydConnect - A blog system for Usyd students.
Developed by: Sally Kang Chen Meng Dylan Mitri
This is the readme for our implemented project, for ELEC5619. Our goal was to create a blog system using Spring's MVC frameworks, as well as MySQL to store our data (and hibernate to communicate), and various web technologies like bootstrap, javascript, and bitbucket. Our project was developed around 2 core fields, Users and Posts, each with seperate domains, controllers, services, and Dao layers. We developed a REST API for both our users and posts, ad well as implementing an external API.
You will need the Spring Tool Suit (STS), 3.8.4 minimum, as well as JavaSE 1.8, and MySQL. The required dependencies and configurations are included in the source code.
Installation: You can download or clone the source code from bitbucket. Once downloaded, open up STS and import the project from the directory it was saved on, or, clone the repositoy onto your local system via git.
To deploy the project from your machine, you will have to modify the database context, changing the root and password to that of your machines database.
Testing/bugs: Our code has some test cases for all the layers or implementation, and, unfortinuatly, still some bugs with some features. To run the tests, run the test cases inside the test package. Some known bugs include the path for displaying images.
Documentation: Our code contains comments to enable users to understand our implementation.
