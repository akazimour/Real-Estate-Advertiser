# Real-Estate-Advertiser

This is a small Spring Boot beta project for an initial real estate advertiser application.
It uses HATEOAS, basic authorization for security and PostGreSql databse (you can change it to H2).
You can access to the REST end points using user as username and password for password or 
you can log in as manager with the same password. The application is able to register new
properties, with specified title, description and other advertisement settings.
Once the user searches a particular advertisement, the application returns with the data
of that property except phone number, and insert a specific interest type to that property.
You have an opportunity to get the phone number related to that advertisement and this time
the application inserts another type of interest to the database releted to the property.

These two type of interests related to the user as well so one user can not have multiple
interests every time when he check the same property. If the same user check the same
property multiple times, application returns with a console message and not insert additional
interests. You can easily navigate between different endpoints using hateoas links.


