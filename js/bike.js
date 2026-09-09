class Bike {
    constructor(brand, color, speed) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
    }

    accelerate() {
        this.speed += 20;
        console.log(`${this.brand} is accelerating. Speed is now ${this.speed} km/h.`);
    }

    brake() {
        if (this.speed >= 10) {
            this.speed -= 10;
        } else {
            this.speed = 0;
        }

        console.log(`${this.brand} is braking. Speed is now ${this.speed} km/h.`);
    }

    stop() {
        this.speed = 0;
        console.log(`${this.brand} has stopped.`);
    }
}


class ElectricBike extends Bike {
    constructor(brand, color, speed, batteryCapacity, currentCharge, distance) {
        super(brand, color, speed);

        this.batteryCapacity = batteryCapacity;
        this.currentCharge = currentCharge;
        this.distance = distance;
    }

    // Method overriding
    accelerate() {
        if (this.currentCharge > 0) {
            this.speed += 20;
            this.currentCharge -= 10;

            console.log(
                `${this.brand} is accelerating. Speed is now ${this.speed} km/h.`
            );
        } else {
            console.log("Battery is empty. Cannot accelerate.");
        }
    }

    chargeBattery() {
        this.currentCharge = this.batteryCapacity;
        console.log("Battery is fully charged.");
    }

    displayBatteryStatus() {
        console.log(
            `Battery: ${this.currentCharge}/${this.batteryCapacity} units`
        );
    }
}

const normalBike = new Bike("Hero", "Red", 0);

normalBike.accelerate();
normalBike.brake();
normalBike.stop();



const eBike = new ElectricBike(
    "TeslaBike",
    "Black",
    0,
    100,
    40,
    10
);

eBike.displayBatteryStatus();
eBike.accelerate();
eBike.accelerate();
eBike.brake();
eBike.stop();
eBike.chargeBattery();
eBike.displayBatteryStatus();
