# Ionic

- a framework built on top of Apache Cordova thatcreates hybrid apps that run, mostly as a webview, onboth Android and iOS

- uses Angular by default, but can be used with bothReact & Vue 

- comes with the powerfull Ionic CLI

- comes with an on-device testing tool called IonicDevApp (ionic serve -devapp)

- project structure is very similar to Angular

- has an official UI library

- has a preconfigured theme file in which colors &shades are declared

- they can be applied using specific Ionic attributes(ex: color="dark" will reference "--ion-color-dark:#000000" from theme)

- the metadata configuration file is "config.xml" andit's similar to Android's AndroidManifest.xml

#
## Ionic UI Components examples
- `<ion-header></ion-header>`
- `<ion-toolbar></ion-toolbar>`
- `<ion-title></ion-title>`
- `<ion-content></ion-content>`

#
## Basic CLI Commands

- `ionic start <<project_name>>` 
    - creates a new ionic project
    - can generate standard UI components such as tabs or sidemenu
            
- `ionic generate page/component/directive/service <<name>>` 
    - creates a new component
    - uses Angular CLI underneath
            
- `ionic serve` 
    - starts a development server

- `ionic cordova run android` 
    - runs the app on a connected Android device

- `ionic cordova build --release <<os>>` 
    - produces a release build
