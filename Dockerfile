FROM openjdk:17
EXPOSE 8091
ADD target/MyTravelBuddyFlightBookings-0.0.1-SNAPSHOT.war MyTravelBuddyFlightBookings-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java", "-jar", "/MyTravelBuddyFlightBookings-0.0.1-SNAPSHOT.war" ]