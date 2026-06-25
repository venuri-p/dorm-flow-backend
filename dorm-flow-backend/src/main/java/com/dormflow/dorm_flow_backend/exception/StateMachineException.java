package com.dormflow.dorm_flow_backend.exception;

/**
 * Exception used to isolate terminal anomalies handled by the service state layers, such as:
 * - Sequence Violations: e.g., submitting an OUT event when already OUT.
 * - Access Rejections: e.g., gate entry denied due to an INACTIVE profile.
 */
public class StateMachineException extends RuntimeException {
    public StateMachineException(String message) {
        super(message);
    }
}
