# User Guide

## Features 

### Feature 1 
Description of feature.

## Usage

### `list` - lists all tasks

Lists all tasks

Example of usage: 

`list`

Expected outcome:

`1. [T] [X] do homework`


### `delete` - deletes a task

Deletes a task from list of tasks

Example of usage: 

`delete 1`

Expected outcome:

`"I got you fam. I've removed this task: 
[T] [X] do homework
Now you have 0 tasks in the list.");`

### `todo` - add ToDo task

Add ToDo task

Example of usage: 

`todo do homework`

Expected outcome:

`Now you have 1 tasks in the list.`


### `deadline` - add deadline task

Add deadline task

Example of usage: 

`deadline do homework/by date`

Expected outcome:

`Now you have 1 tasks in the list.`


### `Event` - add Event task

Add Event task

Example of usage: 

`event attend wedding/at end of the week`

Expected outcome:

`Now you have 1 tasks in the list.`


### `find` - find tasks containing keyword

Find tasks containing keyword

Example of usage: 

`find wedding`

Expected outcome:

`[D] [X] attend wedding (at: end of the week)`


### `done` - mark task as done

Mark task at given index as done

Example of usage: 

`done 1`

Expected outcome:

`Yeah boy, you have completed: attend wedding`


### `bye` - end application

Saves the tasks and exits application

Example of usage: 

`bye`

Expected outcome:

`Holla at me soon homie.`
