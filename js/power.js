// Appliance objects
const TV = {
    name: "TV",
    isOn: false
};

const Lamp = {
    name: "Lamp",
    isOn: false
};

const Oven = {
    name: "Oven",
    isOn: false
};


// Turn ON appliance
function turnOnAppliance(appliance) {
    try {
        if (appliance.isOn) {
            throw new Error(appliance.name + " is already ON.");
        }

        appliance.isOn = true;
        return appliance.name + " turned ON successfully.";
    }
    catch (error) {
        return "Error: " + error.message;
    }
    finally {
        console.log("Operation completed.");
    }
}


// Turn OFF appliance
function turnOffAppliance(appliance) {
    try {
        if (!appliance.isOn) {
            throw new Error(appliance.name + " is already OFF.");
        }

        appliance.isOn = false;
        return appliance.name + " turned OFF successfully.";
    }
    catch (error) {
        return "Error: " + error.message;
    }
    finally {
        console.log("Operation completed.");
    }
}


console.log(turnOnAppliance(TV));
console.log(turnOnAppliance(Lamp));
console.log(turnOnAppliance(Oven));

console.log(turnOffAppliance(TV));
console.log(turnOffAppliance(Lamp));
console.log(turnOffAppliance(Oven));

console.log(turnOffAppliance(TV));
