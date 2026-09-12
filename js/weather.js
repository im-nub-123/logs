const weatherData = {
    "Sydney": 28,
    "Mumbai": 32,
    "London": 18,
    "New York": 25
};


// Mock API
function fetchWeather(city) {
    return new Promise((resolve, reject) => {

        if (!city) {
            reject("City name is missing");
        } 
        else if (weatherData[city] === undefined) {
            reject("City not found");
        } 
        else {
            resolve(weatherData[city]);
        }
    });
}


// Async function
async function getWeather(city) {
    try {
        const temperature = await fetchWeather(city);

        console.log(`Temperature in ${city} is ${temperature}°C`);
    } 
    catch (error) {
        console.log(`Failed to fetch weather: ${error}`);
    } 
    finally {
        console.log("Weather check completed");
    }
}


// Test cases
getWeather("Sydney");
getWeather("");
getWeather("Brazil");
