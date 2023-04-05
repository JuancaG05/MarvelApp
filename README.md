# MarvelApp
This Android app is created for practise purposes and makes itself a simple PoC (proof of concept) on how to build an app with a clean architecture,
as explained below.

The app consists of as list of Marvel characters retrieved from the [Marvel Developer Portal API](https://developer.marvel.com/) displayed in cards
in the main screen. When clicking one of the cards, the app will redirect to a details screen which shows the name, picture and description of the
corresponding Marvel character 🦸🏼‍♂️.

It's important to highlight that this project, since it is just a PoC, lacks of many aspects that would be fundamental in a real project. Some of
these points are:
- Unit tests
- UI tests
- CI/CD
- Improvements in UI (DiffUtil for RecyclerView, good-looking theme and styles...)

## App architecture
The app in this repo tries to follow a clean architecture. In this case, I decided to create a 3-module app, where each module corresponds directly
to one layer of the [clean architecture schema recommended by Android](https://developer.android.com/topic/architecture#recommended-app-arch),
as shown here:

![Android clean architecture](https://user-images.githubusercontent.com/57049315/229296111-29404d4f-857f-467a-bc52-da22fb6f4177.png)

This allows us to have a **separation of concerns** (ideally, each class will only have a single responsibility), which leads to a more cohesive and
less coupled code, and a **independency between modules**, which allows to build them separately, have different external dependencies such as libraries
if needed. The aim of each module/layer is explained briefly next.

### Presentation
This is the one corresponding to "UI Layer" in the previous diagram. Here, we store the different classes related to the UI, which is the closest
part to the user. In this case, we have the main application, main activity, and the different fragments used to represent the screens of the app.
Also, we include the ViewModels of each screen here, since we are using the **MVVM** pattern to separate logic directly related with UI and its components
(which will be located in activities, fragments, adapters or related classes) from logic used to perform needed calculations for UI and communication
with the other layers (located in the ViewModels).

The decision on how to organize all these classes in the module was creating a package per feature, so that we can easily find code related to a
specific functionality.

### Domain
This module contains all the business logic, which should be Android-independent. Same as in the presentation layer, we have a package for each feature,
and inside those feature-packages, we have a "model" package which includes the domain model classes that represent the different objects we are working
with, and a "usecases" package, which includes the use cases invoked in the ViewModels to perform the different actions required and that will
communicate with lower layers. Inside the feature package we also have the interface for a repository, which will be the responsible for retrieving
the data from remote and local datasources and return it in a usable state.

### Data
This is the deeper layer, and includes logic used to access each of the sources where we retrieve the data from, also divided by features to keep it
consistent with the other two layers. Specifically, we can find a "database" package with the entities and DAOs needed to access the local database,
a "network" package with logic responsible to access remote sources like APIs, a "repository" package which includes the implementations for the
interfaces defined in the previous layer, and a "datasources" package, which includes the interfaces and the implementations of the local and remote
datasources directly accessed from the repository class and in charge of using the "database" and "network" classes, respectively.

## Libraries used
Some of the most important libraries used in this project are:
- **Koin** for dependency injection
- **Coil** for printing images retrieved from the Internet
- **Room** for access to local database
- **Retrofit** for network calls made to the Internet
- **Moshi** for parsing JSONs coming from the Internet into app's business logic
