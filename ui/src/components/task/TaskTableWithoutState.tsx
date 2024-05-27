import { useEffect, useRef } from "react";
import { Table } from "react-bootstrap";
import { Root, createRoot } from "react-dom/client";

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

export const TaskTableWithoutState = () => {
    const contentRef = useRef<HTMLDivElement>(null);
    const rootRef = useRef<Root | null>(null);

    useEffect(() => {
        fetch("http://localhost:8080/api/tasks")
            .then((response) => response.json())
            .then((data) => {
                if (contentRef.current) {
                    const content = (
                        <div className="container">
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
                                    {data.map((task: Task) => (
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

                    if (!rootRef.current) {
                        rootRef.current = createRoot(contentRef.current);
                    }
                    rootRef.current.render(content);
                }
            });
    }, []);

    return <div id="content" ref={contentRef}></div>;
};
