import React, { useState } from "react";

function App() {

  const [tasks, setTasks] = useState([
    {
      id: 1,
      title: "Купити молоко",
      description: "2 літри молока"
    },
    {
      id: 2,
      title: "Купити хліб",
      description: "Білий хліб"
    }
  ]);

  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  const addTask = () => {

    if (!title) {
      return;
    }

    const newTask = {
      id: Date.now(),
      title,
      description
    };

    setTasks([...tasks, newTask]);

    setTitle("");
    setDescription("");
  };

  const deleteTask = (id) => {

    setTasks(
      tasks.filter(task => task.id !== id)
    );
  };

  const editTask = (id) => {

    const newTitle =
      prompt("Нова назва задачі");

    const newDescription =
      prompt("Новий опис задачі");

    setTasks(
      tasks.map(task =>
        task.id === id
          ? {
              ...task,
              title: newTitle,
              description: newDescription
            }
          : task
      )
    );
  };

  const showDetails = (task) => {

    alert(
      `Назва: ${task.title}\nОпис: ${task.description}`
    );
  };

  return (
    <div style={{ padding: "20px" }}>

      <h1>Система управління задачами</h1>

      <input
        type="text"
        placeholder="Назва задачі"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />

      <br /><br />

      <input
        type="text"
        placeholder="Опис задачі"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
      />

      <br /><br />

      <button onClick={addTask}>
        Додати
      </button>

      <hr />

      <ul>

        {tasks.map(task => (

          <li key={task.id}>

            <b>{task.title}</b>

            <br /><br />

            <button
              onClick={() => showDetails(task)}
            >
              Деталі
            </button>

            {" "}

            <button
              onClick={() => editTask(task.id)}
            >
              Редагувати
            </button>

            {" "}

            <button
              onClick={() => deleteTask(task.id)}
            >
              Видалити
            </button>

            <br /><br />

          </li>

        ))}

      </ul>

    </div>
  );
}

export default App;
