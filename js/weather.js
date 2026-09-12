const weatherData = {
    "Sydney": 28,
    "Mumbai": 32,
    "London": 18,
    "New York": 25
};

function fetchWeather(city) {
    return new Promise((resolve, reject) => {

        if (!city || city.trim() === "") {
            reject("City name is missing");
        } else {
            const cityName = city.trim();

            const matchingCity = Object.keys(weatherData).find(
                key => key.toLowerCase() === cityName.toLowerCase()
            );

            if (matchingCity) {
                resolve(weatherData[matchingCity]);
            } else {
                reject("City not found");
            }
        }
    });
}

async function getWeather(city) {
    try {
        const temperature = await fetchWeather(city);
        console.log(`Temperature in ${city} is ${temperature}°C`);
    } catch (error) {
        console.log(`Failed to fetch weather: ${error}`);
    } finally {
        console.log("Weather check completed");
    }
}
