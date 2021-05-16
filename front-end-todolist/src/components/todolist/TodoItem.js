import React, { useState } from 'react'


function TodoItem(props) {

    const {id, title, completed} = props.todo;

    return (
        <li className="todo-item">
            <input
                type="checkbox"
                checked={completed}
                onChange={() => props.onChangeInput(id)}
            />
            <span className={completed ? "completed" : ""}>
            {title}
            </span>
            <button className="btn-style"> X </button>
        </li>
    );
}

export default TodoItem;