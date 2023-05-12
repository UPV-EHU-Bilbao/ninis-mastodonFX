<h1 align="center">Mastodon Project</h1>
<div align="center">
  <img width="200" src="src/main/resources/eus/ehu/sprint1/Mastodon_logotype_(simple)_new_hue.svg.png">
  <p align="center"><i>This application has been developed for the Software Engineering (SE) course.</i></p>
</div>


This is a Mastodon project doing , a decentralized and open-source microblogging social network. Mastodon is an alternative to centralized platforms like Twitter, and allows users to create their own instances, giving them greater control over their online experience.




## Authors
- [Alvaro Iturriza](https://github.com/Iturri12)
- [Lander Soriano](https://github.com/s0ri23)
- [Iker Zaldua](https://github.com/izaldua)
- [Alaitz Shan Ye](https://github.com/Alaitz19)



## Installation
### Prerequisites
- In order to handle with Mastodon, you have to register in [Mastodon](https://mastodon.social/auth/sign_in), and require a TOKEN from developer mode. Then, add your token to TOKEN label.

- Clone the Mastodon repository onto your server:
https://github.com/UPV-EHU-Bilbao/ninis-mastodonFX.git
## Project development
- [1<sup>st</sup> Iteration](#1st-iteration-authentication-and-initial-use-cases)
- [2<sup>nd</sup> Iteration](#2nd-iteration-migration-to-javafx-and-more-use-cases)
- [3<sup>rd</sup> Iteration](#3rd-iteration-advanced-design-dashboards-and-rest-api)



### 1<sup>st</sup> Iteration. Initial use cases
For this first iteration, we are asked to define the requirements of the application, based on 3 initial use cases:
- [Show my toot](../../issues/1)
- [Show following](../../issues/7)
- [Show followers](../../issues/3)


For each of these use cases, we have to:
- Create the use case diagram, including flow of events
- Update the domain model
- Draw the mockup GUI
- Implement the use case

**List of tasks carried out during iteration:**

Compulsory
- [x] [Created the use case diagram and flow of events, including the four use cases aforementioned](https://github.com/UPV-EHU-Bilbao/ninis-mastodonFX/blob/main/docs/MastodonUML.mdj).
- [x] Updated the [domain model](https://github.com/UPV-EHU-Bilbao/ninis-mastodonFX/blob/main/docs/MastodonUML.mdj) with the necessary objects
- [x] Designed the [mockups](https://github.com/UPV-EHU-Bilbao/ninis-mastodonFX/blob/main/docs/main_window.png) for the entire first iteration.
- [x] Implementation of the four use cases in form of GUIs, data accesses to the database and business logic intermediary methods. 


---

### 2<sup>nd</sup> Iteration. Implement API from BigBone and more use cases

 
With the proposed migration to BigBone, we have invested much of the time spent on the project in changing the api call from [okhttp3](https://github.com/Stocard/okhttp/packages/491559) to [bigbone](https://github.com/andregasser/bigbone).

**List of tasks carried out during iteration:**

Compulsory
- [x] [Upgrade Domain Model and Event flows](https://github.com/UPV-EHU-Bilbao/ninis-mastodonFX/blob/main/docs/MastodonUML.mdj).
- [x] Improve design of:
      * Show toots
      * Show followers
      * Show Followings
- [x] Use cases:
      * Register
      * Login
      * Post a toot
      * Logout

---


### 3<sup>rd</sup> Iteration. Hibernation, resource bundles and more use cases

For this latest iteration, we have tried to improve the user experience adding a timeline and perfile GUIs.

To do this, we have implemented dark mode, the use case of perfile and now if you don't want to register you can go back to login scene .

**List of tasks carried out during iteration:**

Compulsory
- [x] [Upgrade Domain Model and Event flows](https://github.com/UPV-EHU-Bilbao/ninis-mastodonFX/blob/main/docs/MastodonUML.mdj).
- [x] Select accounts
- [x] Change to dark mode
- [x] Implement timeline to show toots people I follow 
- [x] Implements hibernate
- [x] Implements change of language
- [x] Use case of profile, where there are follwoing, followers and my toot
- [x] Improve post my toot, now you can post image and text with spoiler message
- [x] Improve design of:
      * Show toots
      * Show followers
      * Show Followings
 


