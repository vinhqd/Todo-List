import React, { useState } from 'react';

import Header from './layouts/Header';
import Todos from './Todos';
import AddTodo from './AddTodo'

function TodoApp() {

    const [state, setState] = useState({
        todos: [
            {
                id: 1,
                title: "To do 1",
                completed: false
            },
            {
                id: 2,
                title: "To do 2",
                completed: false
            },
            {
                id: 3,
                title: "To do 1",
                completed: true
            }
        ]
    });

    const onChangeInput = id => {
        setState({
            todos: state.todos.map(todo => {
                if (todo.id === id) {
                    todo.completed = !todo.completed;
                }
                return todo;
            })
        })
    }


    return (
        <div className="container-todo">
            <Header />
            {/* <AddTodo /> */}
            <Todos todos={state.todos} onChangeInput={onChangeInput} />
        </div>
    );
}

export default TodoApp;