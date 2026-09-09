function displayDay(releaseDate) {
    const date = new Date(releaseDate);

    // Check if date is invalid
    if (isNaN(date.getTime())) {
        return "Invalid date";
    }

    const days = ["Sunday", "Monday", "Tuesday", "Wednesday", 
                  "Thursday", "Friday", "Saturday"];

    const day = days[date.getDay()];

    if (day === "Saturday" || day === "Sunday") {
        return "Movie releases on " + day + ". It is a weekend!";
    } else {
        return "Movie releases on " + day + ". It is a weekday.";
    }
}

console.log(displayDay("2024-06-14"));
