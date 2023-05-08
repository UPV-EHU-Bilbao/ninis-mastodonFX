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
- [0<sup>th</sup> Iteration](#0th-iteration-project-setup)
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

The end user can now enjoy a UI decorated with a selective  and a wide range of new components that facilitate and improve navigation, as well as a set of new utilities and use cases for an optimal application experience.

**List of tasks carried out during iteration:**

Compulsory



Optional/Extras



---


### 3<sup>rd</sup> Iteration. 

For this latest iteration, we have tried to improve the user and administrator experience as much as possible.

To do this, .

**List of tasks carried out during iteration:**

Compulsory



Optional/Extras
- [x] Use cases (admin)




- [x] Use cases (user)

  
  The user now enjoys a pleasant and easy-to-use interface, with a wide range of components and animations that will enhance the experience significantly. The overview offered by the main panel of the allows the user to know his/her track record in the application, the bets placed, the money won and even the fluctuations of his/her wallet over the last month.

- [x] Redesign and UI creation
 


