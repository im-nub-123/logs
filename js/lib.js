const book = {
    title: "The Great Gatsby",
    author: "F. Scott Fitzgerald",
    yearPublished: 1925,
    isAvailable: true,

    borrowBook: function () {
        if (this.isAvailable) {
            this.isAvailable = false;
            console.log("Book borrowed successfully.");
        } else {
            console.log("Book is already borrowed.");
        }
    },

    returnBook: function () {
        if (!this.isAvailable) {
            this.isAvailable = true;
            console.log("Book returned successfully.");
        } else {
            console.log("Book is already available.");
        }
    },

    displayDetails: function () {
        console.log("Title: " + this.title);
        console.log("Author: " + this.author);
        console.log("Year Published: " + this.yearPublished);
        console.log("Available: " + (this.isAvailable ? "Yes" : "No"));
    }
};


// Initial details
console.log("Initial Book Details:");
book.displayDetails();


// Borrow book
console.log("Borrowing Book...");
book.borrowBook();
book.displayDetails();


// Return book
console.log("Returning Book...");
book.returnBook();
book.displayDetails();


// Add new property
console.log("Adding new property 'genre'...");
book.genre = "Classic Fiction";
console.log("Updated Book Object:", book);


// Update existing property
console.log("Updating 'yearPublished'...");
book.yearPublished = 1926;
console.log("Updated Book Object:", book);


// Delete existing property
console.log("Deleting 'author' property...");
delete book.author;
console.log("Updated Book Object:", book);
