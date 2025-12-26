## Low Level Design (LLD) – Class Diagram
   - Below is the detailed Low-Level Design (LLD) 
   - class diagram representing all major classes, interfaces, relationships, and design 
      patterns used in the project.

# ##################################################
#                    ParkingFloor                  #
# ##################################################
# - floorNumber : int                              |
# - parkingSpots : List<ParkingSpot>               |
# ------------------------------------------------ #
# + getFloorNumber()                               |
# + getParkingSpots()                              |
# --------------------------------------------------

# ##################################################
#                    ParkingSpot                   #
# ##################################################
# - spotId : String                                |
# - floorNumber : int                              |
# - supportedVehicleType : VehicleType             |
# - available : boolean                            |
# --------------------------------------------------
# + getSpotId()                                    |
# + getFloorNumber()                               |
# + getSupportedVehicleType()                      |
# + isOccupied()                                   |
# + release()                                      |
# --------------------------------------------------

# ##################################################
#                ParkingTicket                     #
# ##################################################
# - ticketId : String                              |
# - vehicleNumber : String                         |
# - spotId : String                                |
# - available : boolean                            |
# - EntryTime : DateTime                           |
# - exitTime : DateTime                            |
# - parkingFee : double                            |
# --------------------------------------------------
# + getTicketId()                                  |
# + getSpotId()                                    |
# + getEntryTime()                                 |
# + getExitTime()                                  |
# + getParkingFee()                                |
# --------------------------------------------------

# ##################################################
#               Vehicle                            #
# ##################################################
# - vehicleNumber : String                         |
# - vehicleType : VehicleType                      |
# --------------------------------------------------
# + getVehicleNumber()                             |
# + getVehicleType()                               |
# --------------------------------------------------

# ##################################################
#              VehicleType (E)                     #
# ##################################################
# + MOTORCYCLE,CAR, BUS                            |
# --------------------------------------------------

# ##################################################
#               FeeStrategy (I)                    #
# ##################################################
# + calculateFee(long durationInHours)             |
# --------------------------------------------------
#                       ^                          #
# ##################################################
#           BusFeeStrategy                         #
# ##################################################
# + calculateFee(long durationInHours)             |
# --------------------------------------------------

# ##################################################
#               FeeStrategy (I)                    #
# ##################################################
# + calculateFee(long durationInHours)             |
# --------------------------------------------------
#                       ^                          #
# ##################################################
#           MotorcycleFeeStrategy                  #
# ##################################################
# + calculateFee(long durationInHours)             |
# --------------------------------------------------

# ##################################################
#               FeeStrategy (I)                    #
# ##################################################
# + calculateFee(long durationInHours)             |
# --------------------------------------------------
#                       ^                          #
# ##################################################
#           CarFeeStrategy                         #
# ##################################################
# + calculateFee(long durationInHours)             |
# --------------------------------------------------

# ##################################################
#            NotificationService                   #
# ##################################################
# - observers : List<Observer>                     |
# --------------------------------------------------
# + addObserver(Observer)                          |
# + notifyAll(String message)                      |
# --------------------------------------------------

# ##################################################
#            NoSpotAvailableException              #
# ##################################################
# extends RuntimeException                         |
# --------------------------------------------------

# ##################################################
#            VehicleTypeNotSupportedException      #
# ##################################################
# extends Exception                                |
# --------------------------------------------------

# ##################################################
#               ParkingService                     #
# ##################################################
# - spotAllocationService : SpotAllocationService  |
# - feeCalculator : FeeCalculator                  |
# - activeTickets : Map<String, ParkingTicket>     |
# - ticketSpotMap : Map<String, ParkingSpot>       | 
# --------------------------------------------------
# + checkIn(Vehicle)                               |
# + checkOut(String,Vehicle Type)                  |
# --------------------------------------------------

# ##################################################
#               SpotAllocationService              #
# ##################################################
# - parkingFloors : List<ParkingFloor>             |
# --------------------------------------------------
# + allocateSpot(Vehicle Type)                     |
# + releaseSpot(ParkingSpot)                       |
# --------------------------------------------------

# ##################################################
#                     Main                         #
# ##################################################
# + main(String[])                                 #
# --------------------------------------------------

# ##################################################
#        Database Schema (Relational)              #
# ##################################################
# Tables:                                          #
# 1. ParkingSpot                                   #
#    - spot_ID (PK)                                #   
#    - floor_number                                #
#    - supported_vehicle_type                      #    
#    - is_occupied                                 #
# --------------------------------------------------
# 2. ParkingTicket                                 #
#    - ticket_ID (PK)                              #
#    - vehicle_number                              #
#    - spot_ID (FK)                                #
#    - entry_time                                  #
#    - exit_time                                   #
#    - parking_fee                                 #
#---------------------------------------------------
# 3. Vehicle                                       #
#    - vehicle_number (PK)                         #
#    - vehicle_type                                #
# ##################################################

