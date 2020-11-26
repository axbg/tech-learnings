# svelte

- yet another JS framework 

- works similary to a compiler, without using framework boilerplate code

- uses dependencies at build time, but not in production
  
-  example of a .svelte component
    ```html
    <script>
        import { Link } from 'svelte-routing';
        import { SomeComponent } from 'SomeComponent.svelte';

        let name = "Alex"
    </script>

    <style>
        .nav-wrapper {
            margin: 0 auto;
            color: red;
        }
    </style>

    <nav>
        <p>Hello {name}</p>
        <div class="nav-wrapper">
            <Link href="#">Svelte link</Link>
            <Link href="#">Svelte second link</Link>
        </div>
    </nav>
    ```


- example of .svelte router
    ```html    
    <script>
        import { Router, Link, Route } from 'svelte-routing';
        import { Home } from 'home.svelte';
        import { Contact } from 'contact.svelte';
    </script>

    <Router>
        <div class="container">
            <Route path="/" component={Home} />
            <Route path="/contact" component={Contact} />
        </div>
    </Router>
    ```
#
## Lifecycle

- just like any other JS framework, svelte comes with special methods that will be called at specific times during the lifecycle of the component

- `onMount` 
    - called right after the component is first rendered
    ```html
    <script>
        import { onMount } from 'svelte';
                        
        onMount(async () => {
            console.log("Component has rendered");
        })
    </script>
    ```

- `onDestroy` 
    - called when the component is destroyed

- `beforeUpdate/afterUpdate` 
    - schedules work to happen just right before/after the DOM was updated
- `tick` 
    - can be called anytime and returns a promise that resolves as soon as any pending state changes have been applied to DOM
    - it's necessary because Svelte doesn't update the DOM after each state change, but tries to update the state using batches, for performance reasons

- the lifecycle methods can be called inside a component even if they are defined in another function
    - defining the logic inside a helper function
        ```js
        import { onDestroy } from 'svelte';
        export function onInterval(callba  milliseconds) {
            const interval = setInterval(callback, milliseconds);

            onDestroy(() => {
                clearInterval(interval);
            });
        }
        ```
    - calling it inside the component
         ```js
         <script>
             import { onInterval } from './utils.js';

             let seconds = 0;
             onInterval(() => seconds += 1, 1000);
         </script>
         ```

#
## Syntax Highlights

- to inject html strings inside a component
    ```html
    <script>
        let inject = "<strong>this contains html</strong>";
    </script>

    <p>{@html inject}</p>
    ```

- if-else statements
    ```html
    <div>
        {#if condition}
            <div>Loading</div>
        {:else if condition}
            <div>Loaded</div>
        {:else}
            <div>something else</div>
        {/if}
    </div>
    ```

- loops
    ```html
    <div>
        {#each array as element}
            <p>{element.title}</p>
        {/each}
    </div>
    ```

- two-way binding for inputs
    ```html
    <script>
        let name = ""
    </script>
    <div>
        <form>
            <input type="text" bind:value={name} />
        </form>
    </div>
    ```

- reactive binding between variables
     - without the $: notation, the title will not be updated each time the someVariable changes 
        ```html
        <script>
            $: title = someVariable;
        </script>
        ```

- awaiting for promises to resolve directly into the html template
    ```html
    <script>
        async function getSomething() {
            return Promise.resolve("something");
        }

        let promise = getSomething();
    </script>
    <div>
        {#await promise}
            <p>waiting</p>
        {:then result}
            <p>showing the {result}</p>
        {:catch error}
            <p>catched an error: {error}</p>
        {/await}
    </div>
    ```

- can add event handlers using the "on" keyword
    ```html
    <div on:mousemove={() => console.log("mouse moved")}>Basic container</div>
    ```

            
- has built-in debug features to inspect variables values each time they change
    * `{@debug user}`


- can pass props from parent to child
    - props can have a default value specified in the child declaration
    ```html
    <!--parent component-->
    <script>
        import { Child } from 'child.svelte';
    </script> 
    <Child age={12} />

    <!--child component-->
    <script>
        export let age;
    </script>
    <p>{age}
    ```

- can propagate events between components 
    - emitting component
        ```html
        <script>
            import { createEventDispatcher } from 'svelte';

            const dispatch = createEventDispatcher();

            dispatch('eventName', payload);
        </script>
        ```
    - listening component
        ```html
        <script>
            function callSomething(payload) {
                console.log("event received");
            }
        </script>
        <div>
            <button on:eventName={callSomething}
        </div>
        ```

- has a built-in store mechanism that can keep state outside components
    - svelte stores can be writable or readable
        ```html
        <!--store definition inside store.js file-->
        import { writable } from 'svelte/store';
        export const count = writable(0);

        <!--change store in a component inside Increment.svelte-->
        <script>
            import { count } from './stores.js';

            function increment() {
                count.update(n => n + 1);
            }
        </script> 

        <button on:click={increment}>
            increment
        </button>

        <!--listen for store changes in another component-->
        <script>
            import { count } from './stores.js';

            const unsubscribe = count.subscribe(value => {

            })

            onDestroy(unsubscribe);
        </script>

        <h1>The value is {$count}</h1>
        <Increment />
        ```
        