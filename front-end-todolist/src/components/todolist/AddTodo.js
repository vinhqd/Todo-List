function AddTodo() {
    return (
        <form className="form-container">
            <input
                type="text"
                placeholder="Add Todo..."
                className="input-text"
                value='Title'
            />
            <input
                type="submit"
                value="Submit"
                className="input-submit" />
        </form>
    );
}

export default AddTodo;