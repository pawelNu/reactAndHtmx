import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";

type Task = {
    id: number;
    name: string;
    subTasks: SubTask[];
};

type SubTask = {
    id: number;
    name: string;
    task: string;
};

export const TaskTableWithState = () => {
    const [tasks, setTasks] = useState<Task[]>([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/tasks")
            .then((response) => response.json())
            .then((data) => {
                setTasks(data);
            });
    }, []);

    return (
        <div id="content" className="container">
            <h1>Lista zadań:</h1>

            <Table bordered hover>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Task</th>
                        <th>SubTasks</th>
                    </tr>
                </thead>
                <tbody>
                    {tasks.map((task: Task) => (
                        <tr key={task.id}>
                            <td>{task.id}</td>
                            <td>{task.name}</td>
                            <td>
                                <ul>
                                    {task.subTasks.map((subTask: SubTask) => (
                                        <li key={subTask.id}>
                                            {subTask.id} {subTask.name}
                                        </li>
                                    ))}
                                </ul>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </div>
    );
};
