let tasks = [];

fetch("shopping.json")
    .then(response => response.text())
    .then(text => {

        tasks = JSON.parse(text);

        renderTasks();
    });

function renderTasks() {

    const list = document.getElementById("shoppingList");

    list.innerHTML = "";

    tasks.forEach((task, index) => {

        const li = document.createElement("li");

        li.innerHTML =
            `${task.name}
            <button onclick="showDetails(${index})">Деталі</button>
            <button onclick="editTask(${index})">Редагувати</button>
            <button onclick="deleteTask(${index})">Видалити</button>`;

        list.appendChild(li);
    });
}

function addTask() {

    const name =
        document.getElementById("taskName").value;

    const description =
        document.getElementById("taskDescription").value;

    tasks.push({
        id: Date.now(),
        name: name,
        description: description
    });

    renderTasks();
}

function deleteTask(index) {

    tasks.splice(index, 1);

    renderTasks();
}

function editTask(index) {

    const newName =
        prompt("Введіть нову назву", tasks[index].name);

    const newDescription =
        prompt("Введіть новий опис", tasks[index].description);

    tasks[index].name = newName;
    tasks[index].description = newDescription;

    renderTasks();
}

function showDetails(index) {

    alert(
        "Назва: " + tasks[index].name +
        "\nОпис: " + tasks[index].description
    );
}
