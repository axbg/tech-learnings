# Angular

## Angular CLI

- ng new app_name
    - creates a new Angular project

- ng serve --open
    - creates a server to run the angular app and opens the browser

- ng g component componentName
    - generates an Angular component

- ng g service serviceName
    - generates an Angular service

#
## Angular Concepts

- `ngOnInit()` method
    - will run when the component is initialized


- to include one component into another you have to modify the html of the parent and include the child component's selector


- when a component is instantiated both `constructor` and `ngOnInit` will run


- use classes and interface as often if a component has a specific object as a property
    - declare them in a separate folder and import them in component


- if you want to parse an array in the template use the *ng-for directive
    ```html
    <li *ng-for="let hobby of hobies; let i = index">{{i}} - {{hobby}}</li>
    ```

- to bind an event to a HTML element you need to use the following syntax
    ```html
    <button (click)="click-me-function()">Click here</button>
    ```

- example of a form with the extraction of a value from an input
    ```html
    <form (submit)="submitFunction(hobby.value)">
        <input type="text" #hobby>
    </form>
    ```

- two-way data-binding
    - you need to import {FormsModule} from "@angular/forms" and add it to the imports in app.module.ts
        ```html
        <input type="text" [(ngModel)]="age" name="age">
        ```


- services 
    - are the perfect place for http calls
    - if you want to use a service in a component you have to import it and then include it in the constructor params of the component
    - to assign the data returned by a service to a component attribute you have to use the .subscribe pipe method 

- http module
    - should be imported inside the app.module.ts and add it as an Angular import
        import {HttpModule} from '@angular/http'
    - it has to be injected in the service constructor
        constructor(private http:Http){}
    - to fetch data just use this.http.get (or other method name) in services' methods
    - to make the fetched data easy to parse you need to import the map module from rxjs (reactive extensions)
        *- import 'rxjs/add/operator/map'
            example: fetchData(){ return this.http.get('url').map(res => res.json())};

- ngIf
    - if you want to display some elements conditionally you can use the ngIf statement
        ```html
        <div *ngIf=isEdit></div>
        ```

- routing
    - first, you need to import the router module
        example: import{RouterModule, Routes} from '@angular/router' in the app.module.ts
    - define a constant of type Routes
        example: const appRouter: Routes = [ {path: 'here-the-path', component: 'the component to be rendered} ];
    - as an Angular import, include 'RouterModule.forRoot(appRoutes);
    - the last step is to change the html of the component which includes the Routes with the <router-outlet></router-outlet> directive

- [methods to transfer data from parent to child or reverse](https://angularfirebase.com/lessons/sharing-data-between-angular-components-four-methods/)