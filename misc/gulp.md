# Gulp

- it's a JavaScript TaskRunner
- it's a "code before configuration" alternative for Grunt

- important auxiliary modules for gulp
    - `gulp-jscs`
    - `gulp-jshint`
    - `jshint`
    - `jshint-stylish`
    - `gulp-util`
    - `gulp-print`
    - `gulp-if`
    - `yargs`

- Gulp has 4 APIs
    - `gulp.task` 
        - used to define a task
    - `gulp.src`
        - used to read data from a source
    - `gulp.dest`
        - used to write data on the disk
    - `gulp.watch`
        - used to watch files for modifications

- available on npm
    - it's a best practice to install it as a dev dependency because it will only be used in development
    - `npm install --save-dev gulp`

#
## Example
- create an empty npm repository

- install gulp 
    
- create a "gulpfile.js" file

- create a gulp task
    ```js
    gulp.task('hello', function() {
        console.log('hello world from gulp');
    })
    ```

- execute `gulp hello` in the terminal

#
## Automation
- two useful tools for JavaScript code analysis are: 
    - `jscs` - codestyle checking
    - `jshint` - detecting errors 

- installing jshint and jscs for gulp
    - `npm install --save-dev jshint gulp-jshint gulp-jscs jshint-stylish`
    - import them in the gulfile.js file
    - in the root directory create .jscsrc and .jshintrc files
    - populate them with default templates

- create gulp tasks that use jshint and jscsrc
    ```js
    gulp.task('vet', function() {
	    return gulp
            .src('./js/*.js')
            .pipe(jscs())
            .pipe(jshint())
            .pipe(jshint.reporter('jshint-stylish', {verbose: true}));
    });
    ```

- plain JavaScript functions can be written in `gulpfile.js` and used inside the tasks

- if you want to output if a script has failed you can use the `jshint.reporter('fail)` command in a pipe

- if you want to display all the files a task will use, you can call the `gulp-print` module inside a pipe after `.src`
    ```js
    var gulpprint = require('gulp-print').default;
        .pipe(gulpprint())
    ```

- if you want to implement conditioning in a gulp task you can use `gulp-if` module
    ```js
    .pipe(gulpif(true/false,action))
    ```

- if you want to have access to the command-line params you can use the `yargs` module
    ```js
    var args = require('yargs').argv
    args.variable_name
    ```

- if you want to load plugins lazily and load all the modules using a single parameter you can use `gulp-load-plugins`
    ```js
    var $ = require('gulp-load-plugins')({lazy: true})
    
    // when you want to use a module, use $.js.module_name
    $.if
    $.jscs
    $.jshint
    ```

#
## Config file
- create a config file for Gulp to define your constants

- create `gulp.config.j` in the root directory

- create a function that defines your constants
    ```js
    module.exports = function(){
        var config = {
            alljs: './js/*.js'
        }

        return config;
    };
    ```

- import it inside your gulpfile.js 
    ```js
    var config = require('gulp.config')
    ```
	
# 
## Browser auto-reload example
```js
gulp.task('sync', function() {
	browserSync.init({
	server: "../"
    });

	gulp.watch("../*.html").on('change', browserSync.reload);
	gulp.watch("../*.css").on('change', browserSync.reload);
	gulp.watch("../*.js").on('change', browserSync.reload);
});
```