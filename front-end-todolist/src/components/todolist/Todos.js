
import TodoItem from './TodoItem';

function Todos(props) {
    return (
        <div>
            <ul>
                {props.todos.map(todo => (
                    <TodoItem todo={todo} onChangeInput={props.onChangeInput} />
                ))}
            </ul>
        </div>
    );
}

export default Todos;