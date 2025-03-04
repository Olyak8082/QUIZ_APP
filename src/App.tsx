import React, { useState } from 'react';
import { questions } from './data/questions';
import { QuizState } from './types';
import './App.css';

function App() {
    const [state, setState] = useState<QuizState>({
        currentQuestionIndex: 0,
        score: 0,
        showResults: false,
        userAnswers: [],
    });

    const currentQuestion = questions[state.currentQuestionIndex];

    const handleAnswer = (selectedAnswer: number) => {
        const newUserAnswers = [...state.userAnswers, selectedAnswer];
        const newScore = selectedAnswer === currentQuestion.correctAnswer
            ? state.score + 1
            : state.score;

        if (state.currentQuestionIndex === questions.length - 1) {
            setState({
                ...state,
                score: newScore,
                showResults: true,
                userAnswers: newUserAnswers,
            });
        } else {
            setState({
                ...state,
                currentQuestionIndex: state.currentQuestionIndex + 1,
                score: newScore,
                userAnswers: newUserAnswers,
            });
        }
    };

    const restartQuiz = () => {
        setState({
            currentQuestionIndex: 0,
            score: 0,
            showResults: false,
            userAnswers: [],
        });
    };

    if (state.showResults) {
        return (
            <div className="quiz-container">
                <h1>Результаты квиза</h1>
                <p>Вы ответили правильно на {state.score} из {questions.length} вопросов</p>
                <button onClick={restartQuiz}>Начать заново</button>
            </div>
        );
    }

    return (
        <div className="quiz-container">
            <h1>Квиз</h1>
            <div className="progress">
                Вопрос {state.currentQuestionIndex + 1} из {questions.length}
            </div>
            <div className="question">
                <h2>{currentQuestion.text}</h2>
                <div className="options">
                    {currentQuestion.options.map((option, index) => (
                        <button
                            key={index}
                            onClick={() => handleAnswer(index)}
                            className="option-button"
                        >
                            {option}
                        </button>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default App; 