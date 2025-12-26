## Main
`com.airtripe.SmartParkingLotSystem.Main` — Entry point. Creates sample data and demonstrates service usage.

## Services
- `ParkingService` — setCheckIN and Checkout Functionality Throws `VehicleTypeNotSupportedException` when type not correct.
- `SpotAllocationService` — set allocateSpot and release allocateSpot Functionality Throws `NoSpotAvailableException` when slot not available.
## Model
- `ParkingFloor`  -this is model class where we provide Parking floor related details like floor number and parking spots.
- `ParkingSpot` — this is model class where we provide Parking Spot related details like floor number,supportedVehicleType,spot available.
- `ParkingTicket`  -this is model class where we provide Parking Ticket related details like ticketId,vehicleNumber,spotId,parkingFee, entry and exit time.
- `Vehicle` — this is model class where we provide Vehicle related details like vehicleNumber and vehicle type..

## Enums
- `VehicleType` — in this Enum we provide the type of vehicle like car ,bus ,motorcycle.

## Exceptions
- `NoSpotAvailableException` — this exception throws when the spot is not found. 
- `VehicleTypeNotSupportedException` — this exception throws when the vehicle type is incorrect.

## Strategy
- `BusFeeStrategy` — inside this class we are calculate the fee of BUS.
- `CarFeeStrategy` — inside this class we are calculate the fee of CAR.
- `MotorcycleFeeStrategy` — inside this class we are calculate the fee of MOTORCYCLE.
- `FeeCalculator` — inside this class we are calculate the functionality according the type of vehicle.
- `FeeStrategy` — inside this interface we are decide the fee calculate Strategy.