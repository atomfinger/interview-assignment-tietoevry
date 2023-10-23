## Interview assignment

### Introduction / Context

The Emporium is a chain of stores that offers a wide variety of goods to meet the needs of everyone. From books to food,
clothing to electronics, furniture to toys, The Emporium has it all under one roof. Our stores are designed to provide
customers with a comfortable shopping experience, where they can easily browse and find what they need. Our
knowledgeable staff is always on hand to help customers find the perfect product, and our competitive prices make
shopping with us a great value. Whether you are looking for a gift, a household product, or just something fun for
yourself, The Emporium has something for everyone. Visit one of our stores today and discover the convenience and
variety that The Emporium has to offer.

The Emporium's systems are old and not well maintained. Over the years, it has been increasingly difficult to make
updates to the tax system, especially as more and more complex changes to the laws have been made. You, a developer at The Emporium,
are tasked with implementing this year's changes to the tax laws while also cleaning up that part of the codebase.

### The Tax Law

In this fictional store, in this fictional country, the tax law is as follows:

- Groceries: 25%, -10%
- Wine: 15%
- Vegetables: 0%
- Books: 0%
- Electronics: 20%

Everything else has a 25% VAT.

Additional rules:

- 5% luxury tax if the product's price equals or exceeds 5000.
- 30% of products imported from Basan (another fictional country) due to trade wars.
- The government subsidises groceries. Its tax rate is 25%, but it has an additional "reverse tax" or "subsidized tax" of -10%, making the total 15%.
  However, both VAT lines need to be present according to local laws.
- VAT should not be displayed if it amounts to 0%.

### Task

- The tax system should adhere to the tax laws stated above above.

- The system should be cleaned up to your standards of production code.

*Hints:*

- Focus your attention on [TaxUtil](/src/main/java/io/github/atomfinger/interview/vat/system/util/TaxUtil.java). This doesn't mean you should limit yourself to that class, but it is the most relevant class for this task.

- There are no guarantees that the code is 100% correct as is.

- Pretend that this code is a part of a much bigger codebase. If you feel the best solution would be to make changes
  that would impact the application as a whole, then make a mental note of it and we can discuss it during the follow-up interview.

- It is okay if the solution isn't perfect or if you're not completely happy with it. As previously mentioned, There's
  no "one correct solution" that we're looking for. Your target should be what you deem acceptable in a production
  system, not perfection.

- If you feel a library would significantly improve, feel free to add it.

### Running the project

This project uses [Gradle](https://gradle.org), but you shouldn't need to install something.

If you're on Windows you need to use the gradlew.bat file, so the commands needs to be changed to (for
example) "`gradlew.bat build`".

You can also use the IDE to build and run the code.

- Build: `./gradlew build`
- Test: '`./gradlew test`'

#### Requirements

- Java 17 or later.

### How to do the assignment

1. Fork the repository to your own GitHub account (or any other Git provider).
2. Implement the changes needed
3. When happy, push the code, send me a link to the repository and add me as a collaborator if the project is privated (GitHub username: atomfinger).
