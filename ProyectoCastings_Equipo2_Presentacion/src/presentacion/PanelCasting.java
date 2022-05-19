package presentacion;

import static Control.FabricaLogica.dameInstancia;
import Control.*;
import ObjetoNegocio.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author Jarol, Daniel y Elisa.
 */
public class PanelCasting extends javax.swing.JPanel {

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat formatoD = new DecimalFormat("#.00");
    List<Fase> fasesAgregadas = new ArrayList();

    Fase fase = new Fase();

    /**
     * Creates new form RegistrarCasting
     */
    ILogica logica;

    public PanelCasting() {
        initComponents();
        logica = dameInstancia();
        datePickerFecha.setDateToToday();
        llenarTabla((ArrayList<Casting>) logica.consularTodosCasting());
        limpiarCampos();

    }

    public JPanel despliegaPanel() {

        this.setSize(1800, 700);// tamano del panel
        this.setLocation(5, 5);// posicion dentro del panel principal
        mostrarListas();

        return this;
    }

    public void mostrarListas() {
        comboBoxAgentes.removeAllItems();

        List<Cliente> clientes = logica.consultarTodosClientes();
        List<Agente> agentes = logica.consultarTodosAgentes();
        if (agentes.size() < 1) {
            tipoPresencial.setEnabled(false);
            tipoEnLinea.setSelected(true);
            esconderCampos();

            JOptionPane.showMessageDialog(this, "No hay agentes disponibles para generar un casting presencial.");
        } else {
            tipoPresencial.setEnabled(true);
            for (Agente agente : agentes) {
                comboBoxAgentes.addItem(agente);
            }
        }
        comboBoxClientes.removeAllItems();
        for (int i = 0; i < clientes.size(); i++) {
            comboBoxClientes.addItem(logica.consultarTodosClientes().get(i));
        }
        ArrayList<Casting> castings = (ArrayList<Casting>) logica.consularTodosCasting();
        llenarTabla(castings);

    }

    public int muestraPregunta() {
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        return resp;
    }

    public void llenarTabla(List<Casting> lista) {

        List<Casting> list = lista;
        DefaultTableModel model = (DefaultTableModel) tblCastings.getModel();

        int rowCount = model.getRowCount();

        for (int m = rowCount - 1; m >= 0; m--) {
            model.removeRow(m);
        }

        Object rowData[] = new Object[9];
        for (int i = 0; i < list.size(); i++) {
            Casting casting = (Casting) list.get(i);
            Cliente cliente = logica.consultarPorID(casting.getClienteId());
            if (casting.getTipo().equals("Presencial")) {
                Casting presencial = (Casting) list.get(i);
                rowData[0] = presencial.getId();
                rowData[1] = presencial.getNombre();
                rowData[2] = presencial.getDescripcion();
                rowData[3] = presencial.getFecha_contratacion();
                rowData[4] = presencial.getCoste();
                rowData[5] = presencial.getTipo();
                rowData[6] = presencial.getNumPersonas();
                rowData[7] = presencial.getAgente().getNombre();
                rowData[8] = cliente.getNombre();

                model.addRow(rowData);

            } else {
                Casting online = (Casting) list.get(i);
                rowData[0] = online.getId();
                rowData[1] = online.getNombre();
                rowData[2] = online.getDescripcion();
                rowData[3] = online.getFecha_contratacion();
                rowData[4] = online.getCoste();
                rowData[5] = online.getTipo();
                rowData[6] = "";
                rowData[7] = "";
                rowData[8] = cliente.getNombre();
                model.addRow(rowData);
            }

        }

    }

    /**
     * Obtiene las fases del comboBox para mandarlas al momento de agregar
     *
     * @throws ParseException
     */
    public void obtenerFases() throws ParseException {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        if (comboBoxFases.getSelectedItem().toString().isEmpty()) {

            for (int i = 0; i < comboBoxFases.countComponents(); i++) {

                fasesAgregadas.add(new Fase(date.parse(comboBoxFases.getItemAt(i))));
            }
        }
    }

    public void mostrarError(Exception ex) {

        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

    }

    /**
     * Muestra mensaje de exito y busca el cliente para obtener el id con el que
     * se registro para mostrarlo en el mensaje
     *
     * @param cliente
     */
    public void mostrarMensajeExito(Casting casting) {
        JOptionPane.showMessageDialog(this, "Registrado con exito casting:" + casting.getId().toString());
        llenarTabla((ArrayList<Casting>) logica.consularTodosCasting());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAgente = new javax.swing.JLabel();
        comboBoxClientes = new javax.swing.JComboBox<>();
        comboBoxAgentes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tipoPresencial = new javax.swing.JRadioButton();
        tipoEnLinea = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFase = new javax.swing.JLabel();
        lblFechafase = new javax.swing.JLabel();
        btnAgregarFase = new javax.swing.JButton();
        lblFasesAgregadas = new javax.swing.JLabel();
        comboBoxFases = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCastings = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        txtCoste = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnRegistrarCasting = new javax.swing.JButton();
        datePickerFecha = new com.github.lgooddatepicker.components.DatePicker();
        lblPersona = new javax.swing.JLabel();
        txtNumeroPersonas = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        fondo.setBackground(new java.awt.Color(174, 198, 207));
        fondo.setMinimumSize(new java.awt.Dimension(1050, 512));
        fondo.setPreferredSize(new java.awt.Dimension(1090, 590));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cliente:");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 140, -1));

        lblAgente.setText("Agente:");
        fondo.add(lblAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, 20));

        comboBoxClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxClientesItemStateChanged(evt);
            }
        });
        fondo.add(comboBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 71, 200, 30));

        fondo.add(comboBoxAgentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 90, -1));

        jLabel3.setText("Tipo de Casting:");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        grupo1.add(tipoPresencial);
        tipoPresencial.setText("Presencial");
        tipoPresencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoPresencialActionPerformed(evt);
            }
        });
        fondo.add(tipoPresencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

        grupo1.add(tipoEnLinea);
        tipoEnLinea.setText("En linea");
        tipoEnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoEnLineaActionPerformed(evt);
            }
        });
        fondo.add(tipoEnLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        jLabel4.setText("Nombre:");
        fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel5.setText("Descripción:");
        fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 20));

        jLabel6.setText("Coste:");
        fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, 20));

        lblFase.setText("Fases");
        lblFase.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fondo.add(lblFase, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        lblFechafase.setText("Fecha fase:");
        fondo.add(lblFechafase, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        btnAgregarFase.setText("Agregar");
        btnAgregarFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFaseActionPerformed(evt);
            }
        });
        fondo.add(btnAgregarFase, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        lblFasesAgregadas.setText("Fases agregadas:");
        fondo.add(lblFasesAgregadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        comboBoxFases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFasesActionPerformed(evt);
            }
        });
        fondo.add(comboBoxFases, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 160, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(453, 404));

        tblCastings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción", "Fecha", "Coste", "Tipo", "Num personas", "Agente", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCastings);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 660, 330));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        fondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 200, 20));

        txtCoste.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCosteKeyTyped(evt);
            }
        });
        fondo.add(txtCoste, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 200, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcion);

        fondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 200, 60));

        btnRegistrarCasting.setText("Registrar Casting");
        btnRegistrarCasting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCastingActionPerformed(evt);
            }
        });
        fondo.add(btnRegistrarCasting, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 140, 40));
        fondo.add(datePickerFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        lblPersona.setText("Num Personas:");
        fondo.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        txtNumeroPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroPersonasKeyTyped(evt);
            }
        });
        fondo.add(txtNumeroPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 90, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        fondo.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarCastingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCastingActionPerformed
        if (txtNombre.getText().trim().isEmpty() || txtCoste.getText().trim().isEmpty()
                || txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar toda la informacion solicitada. \n No deje espacios en blanco.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String tipo = null;
            Cliente cliente = (Cliente) comboBoxClientes.getSelectedItem();
            List<Perfil> p = new ArrayList();
            List<Candidato> c = new ArrayList();

            try {

                if (tipoEnLinea.isSelected()) {
                    try {
                        tipo = tipoEnLinea.getText();
                        Casting castingOnline = new Casting(
                                new ObjectId(),
                                txtNombre.getText().trim().toUpperCase().charAt(0) + txtNombre.getText().trim().substring(1, txtNombre.getText().length()).toLowerCase(),
                                txtDescripcion.getText().trim(),
                                convertToDateUsingDate(datePickerFecha.getDate()),
                                Float.parseFloat(txtCoste.getText().trim()),
                                tipo,
                                p,
                                c,
                                cliente.getId());

                        logica.guardarCasting(castingOnline, cliente);
                        limpiarCampos();
                        mostrarMensajeExito(castingOnline);
                    } catch (Exception e) {
                        mostrarError(new Exception(e.getMessage()));
                    }

                } else if (tipoPresencial.isSelected()) {
                    if (txtNumeroPersonas.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Debe llenar toda la informacion solicitada. \n No deje espacios en blanco.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (comboBoxAgentes.getSelectedItem() != null) {
                            List<PruebaIndividual> listaPruebas = new ArrayList<>();
                            tipo = tipoPresencial.getText();
                            Casting casPresencial = new Casting(
                                    new ObjectId(),
                                    txtNombre.getText().trim().toUpperCase().charAt(0) + txtNombre.getText().trim().substring(1, txtNombre.getText().length()).toLowerCase(),
                                    txtDescripcion.getText().trim(),
                                    convertToDateUsingDate(datePickerFecha.getDate()),
                                    Float.parseFloat(txtCoste.getText().trim()),
                                    tipo,
                                    p,
                                    c,
                                    cliente.getId(),
                                    Integer.parseInt(txtNumeroPersonas.getText().trim()),
                                    (Agente) comboBoxAgentes.getSelectedItem(),
                                    fasesAgregadas,
                                    listaPruebas);

                            logica.guardarCasting(casPresencial, cliente);
                            limpiarCampos();
                            mostrarMensajeExito(casPresencial);
                        }
                    }
                }
            } catch (Exception e) {
                mostrarError(e);
            }
        }
    }//GEN-LAST:event_btnRegistrarCastingActionPerformed
    private Date convertToDateUsingDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    private void comboBoxFasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFasesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxFasesActionPerformed

    private void btnAgregarFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFaseActionPerformed

        try {
            //     fasesAgregadas= new ArrayList();

            String fech = datePickerFecha.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date f = null;
            try {
                f = date.parse(fech);

                // para verificar que la fecha no sea menor a la actual
                fase.verificaDatos(f);

                fase.setFechaInicio(f);
                fase.setPruebaIndividual(new PruebaIndividual());
                comboBoxFases.addItem(fech);
                fasesAgregadas.add(fase);

                // mostrarListaFases();
            } catch (ParseException ex) {
                Logger.getLogger(PanelCasting.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (RuntimeException ex) {
            mostrarError(ex);
        }


    }//GEN-LAST:event_btnAgregarFaseActionPerformed

    public void soloNumeros(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (Character.isDigit(car)) {

        } else {
            evt.consume();
            getToolkit().beep();
        }
    }

    public void soloTexto(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (Character.isLetter(car) || car == ' ') {

        } else {
            evt.consume();
            getToolkit().beep();
        }
    }

    public void numeroDecimal(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();

        if (Character.isDigit(car) || car == '.') {

        } else {
            evt.consume();
            getToolkit().beep();
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void limpiarCampos() {
        txtNombre.setText("");
        txtCoste.setText("");
        txtDescripcion.setText("");
        txtNumeroPersonas.setText("");
        grupo1.clearSelection();
        datePickerFecha.setDateToToday();
        comboBoxFases.removeAllItems();

    }
    private void tipoPresencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoPresencialActionPerformed
        esconderCampos();
    }//GEN-LAST:event_tipoPresencialActionPerformed

    private void tipoEnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoEnLineaActionPerformed
        esconderCampos();
    }//GEN-LAST:event_tipoEnLineaActionPerformed

    private void comboBoxClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxClientesItemStateChanged
        CambiarListaSegunClienteSeleccionadoEnElPanel();
    }//GEN-LAST:event_comboBoxClientesItemStateChanged

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        soloTexto(evt);
        if (txtNombre.getText().trim().length() == 40) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNumeroPersonasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroPersonasKeyTyped
        soloNumeros(evt);
        if (txtNumeroPersonas.getText().trim().length() == 10) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtNumeroPersonasKeyTyped

    private void txtCosteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCosteKeyTyped
        numeroDecimal(evt);
        if (txtCoste.getText().trim().length() == 10) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtCosteKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        if (txtDescripcion.getText().trim().length() == 150) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped
    private void CambiarListaSegunClienteSeleccionadoEnElPanel() {
        Cliente cliente = (Cliente) comboBoxClientes.getSelectedItem();
        if (cliente != null) {
            List<Casting> castings = logica.consultarCastingCliente(cliente.getId());
            llenarTabla(castings);
        }

    }

    private void esconderCampos() {
        boolean invisible = true;
        if (tipoPresencial.isSelected()) {

            txtNumeroPersonas.setVisible(invisible);
            comboBoxAgentes.setVisible(invisible);
            lblFase.setVisible(invisible);
            datePickerFecha.setVisible(invisible);
            btnAgregarFase.setVisible(invisible);
            comboBoxFases.setVisible(invisible);
            lblAgente.setVisible(invisible);
            lblFase.setVisible(invisible);
            lblFasesAgregadas.setVisible(invisible);
            lblFechafase.setVisible(invisible);
            lblPersona.setVisible(invisible);
        } else if (tipoEnLinea.isSelected()) {
            invisible = false;
            txtNumeroPersonas.setVisible(invisible);
            comboBoxAgentes.setVisible(invisible);
            lblFase.setVisible(invisible);
            datePickerFecha.setVisible(invisible);
            btnAgregarFase.setVisible(invisible);
            comboBoxFases.setVisible(invisible);
            lblAgente.setVisible(invisible);
            lblFase.setVisible(invisible);
            lblFasesAgregadas.setVisible(invisible);
            lblFechafase.setVisible(invisible);
            lblPersona.setVisible(invisible);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFase;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrarCasting;
    private javax.swing.JComboBox<Agente> comboBoxAgentes;
    private javax.swing.JComboBox<Cliente> comboBoxClientes;
    private javax.swing.JComboBox<String> comboBoxFases;
    private com.github.lgooddatepicker.components.DatePicker datePickerFecha;
    private javax.swing.JPanel fondo;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAgente;
    private javax.swing.JLabel lblFase;
    private javax.swing.JLabel lblFasesAgregadas;
    private javax.swing.JLabel lblFechafase;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JTable tblCastings;
    private javax.swing.JRadioButton tipoEnLinea;
    private javax.swing.JRadioButton tipoPresencial;
    private javax.swing.JTextField txtCoste;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroPersonas;
    // End of variables declaration//GEN-END:variables

}
